package de.labyhelp.addon.util;

import de.labyhelp.addon.enums.HelpGroups;
import de.labyhelp.addon.enums.NameTags;
import net.labymod.main.LabyMod;
import net.labymod.user.User;
import net.minecraft.util.EnumChatFormatting;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static de.labyhelp.addon.LabyHelp.getInstance;

public class NameTagManager {

    public NameTags currentNameTag = NameTags.RANK;
    private Boolean updateNameTagFinish = false;
    private Boolean updateSubtilesFinish = false;


    public void readNameTags() {
        readSecondNameTag();
        readNameTag();
        getInstance().sendDeveloperMessage("method: readNameTags in NameTagManager");
    }

    public String getDiscoNameTag(String n) {

        StringBuilder finalEndTag = new StringBuilder();
        for (char ch : n.toCharArray()) {
            finalEndTag.append(getInstance().getGroupManager().randomColor(true)).append(ch);
        }

        return finalEndTag.toString();
    }

    public void updateNameTag(boolean readDatabase, boolean firstNameTag) {
        if (readDatabase) {
            if (getInstance().getSettingsManager().onServer) {
                getInstance().getCommunicatorHandler().readUserInformations(false);
            }
            return;
        }
        if (!getInstance().getSettingsManager().seeNameTags) {
            return;
        }
        if (updateNameTagFinish) {
            return;
        }
        updateNameTagFinish = true;

        if (!getInstance().getGroupManager().userNameTags.isEmpty() || !getInstance().getGroupManager().userSecondNameTags.isEmpty()) {
            for (Map.Entry<UUID, User> uuidUserEntry : LabyMod.getInstance().getUserManager().getUsers().entrySet()) {


                if (getInstance().getSettingsManager().getTargetPlayers().containsKey(uuidUserEntry.getKey())) {
                    getInstance().getTargetManager().setTargetNameTag(uuidUserEntry.getKey());
                    break;
                }

                String name = firstNameTag
                        ? getInstance().getGroupManager().userNameTags.getOrDefault(uuidUserEntry.getKey(), null)
                        : getInstance().getGroupManager().userSecondNameTags.getOrDefault(uuidUserEntry.getKey(), null) == null

                        ? getInstance().getGroupManager().userNameTags.getOrDefault(uuidUserEntry.getKey(), null)
                        : getInstance().getGroupManager().userSecondNameTags.getOrDefault(uuidUserEntry.getKey(), null);


                if (getInstance().getGroupManager().isBanned(uuidUserEntry.getKey(), false)) {
                    LabyMod.getInstance().getUserManager().getUser(uuidUserEntry.getKey()).setSubTitle("CENSORED");
                    if (getInstance().getSettingsManager().nameTagSize != 0) {
                        LabyMod.getInstance().getUserManager().getUser(uuidUserEntry.getKey()).setSubTitleSize(getInstance().getSettingsManager().nameTagSize);
                    } else {
                        LabyMod.getInstance().getUserManager().getUser(uuidUserEntry.getKey()).setSubTitleSize(1);
                    }
                } else if (name != null && !name.equals("")) {
                    String finalTag = name.replace("&", "§");
                    String rainbow = finalTag.replace("!r", "" + getInstance().getGroupManager().randomColor(false));

                    String disco = rainbow.replace("!d" + rainbow.replace("!d", ""),
                            getDiscoNameTag(rainbow.replace("!d", "")));

                    if (!getInstance().getGroupManager().isTag(uuidUserEntry.getKey())) {
                        String finishFinalTag = disco.replace("LabyMod", "CENSORED");
                        LabyMod.getInstance().getUserManager().getUser(uuidUserEntry.getKey()).setSubTitle(EnumChatFormatting.WHITE + finishFinalTag);
                    } else {
                        LabyMod.getInstance().getUserManager().getUser(uuidUserEntry.getKey()).setSubTitle(EnumChatFormatting.WHITE + disco);
                    }

                    if (getInstance().getSettingsManager().nameTagSize != 0) {
                        LabyMod.getInstance().getUserManager().getUser(uuidUserEntry.getKey()).setSubTitleSize(getInstance().getSettingsManager().nameTagSize);
                    } else {
                        LabyMod.getInstance().getUserManager().getUser(uuidUserEntry.getKey()).setSubTitleSize(1);
                    }
                }
            }
        }
        updateNameTagFinish = false;
    }


    public void updateSubTitles(boolean readDatabase) {
        if (readDatabase) {
            if (getInstance().getSettingsManager().onServer) {
                getInstance().getCommunicatorHandler().readUserInformations(true);
            }
            return;
        }
        if (!getInstance().getSettingsManager().seeNameTags) {
            return;
        }
        if (updateSubtilesFinish) {
            return;
        }
        updateSubtilesFinish = true;

        if (!getInstance().getGroupManager().userGroups.isEmpty()) {

            for (Map.Entry<UUID, User> uuidUserEntry : LabyMod.getInstance().getUserManager().getUsers().entrySet()) {
                HelpGroups group = getInstance().getGroupManager().userGroups.getOrDefault(uuidUserEntry.getKey(), null);
                if (group != null) {
                    getInstance().getTagManager().setNormalTag(uuidUserEntry.getKey(), group);

                    if (getInstance().getSettingsManager().nameTagSize != 0) {
                        LabyMod.getInstance().getUserManager().getUser(uuidUserEntry.getKey()).setSubTitleSize(getInstance().getSettingsManager().nameTagSize);
                    } else {
                        LabyMod.getInstance().getUserManager().getUser(uuidUserEntry.getKey()).setSubTitleSize(1);
                    }

                    if (group.equals(HelpGroups.TARGET)) {
                        LabyMod.getInstance().getUserManager().getUser(uuidUserEntry.getKey()).setSubTitleSize(getInstance().getSettingsManager().getTargetPlayers().get(uuidUserEntry.getKey()));
                    }
                }

            }
        } else {
            LabyMod.getInstance().getUserManager().getUser(LabyMod.getInstance().getPlayerUUID()).setSubTitle("LabyHelp UNDEFINED");
        }

        updateSubtilesFinish = false;

    }

    private void readNameTag() {
        getInstance().sendDeveloperMessage("called method: readNameTag first");
        getInstance().getGroupManager().userNameTags.clear();
        getInstance().getRequestManager().getStandardHashMap("https://marvhuelsmann.de/nametags.php?which=FIRST_NAMETAG", (HashMap<UUID, String>) getInstance().getGroupManager().userNameTags);
    }


    private void readSecondNameTag() {
        getInstance().sendDeveloperMessage("called method: readNameTag second");
        getInstance().getGroupManager().userSecondNameTags.clear();
        getInstance().getRequestManager().getStandardHashMap("https://marvhuelsmann.de/nametags.php?which=SECOND_NAMETAG", (HashMap<UUID, String>) getInstance().getGroupManager().userSecondNameTags);
    }

    private void moveNameTags() {

        if (currentNameTag == NameTags.RANK) {
            updateSubTitles(false);
            currentNameTag = NameTags.FIRST_NAMETAG;
            getInstance().sendDeveloperMessage("Rank");

        } else if (currentNameTag == NameTags.FIRST_NAMETAG) {
            updateNameTag(false, true);
            getInstance().sendDeveloperMessage("NameTag 1");
            currentNameTag = NameTags.SECOND_NAMETAG;

        } else if (currentNameTag == NameTags.SECOND_NAMETAG) {
            getInstance().sendDeveloperMessage("NameTag 2");
            updateNameTag(false, false);
            currentNameTag = NameTags.RANK;

        } else {
            getInstance().sendDeveloperMessage("else");
            updateSubTitles(false);
            currentNameTag = NameTags.RANK;
        }
    }

    public void updateCurrentNameTagRealTime() {
        if (currentNameTag == NameTags.RANK) {
            updateSubTitles(false);
        } else if (currentNameTag == NameTags.FIRST_NAMETAG) {
            updateNameTag(false, true);
        } else if (currentNameTag == NameTags.SECOND_NAMETAG) {
            updateNameTag(false, false);
        } else {
            updateSubTitles(false);
        }
    }

    public boolean updateNameTags(Integer currentValue) {
        if (getInstance().getSettingsManager().translationLoaded) {
            Integer chooseSeconds = getInstance().getSettingsManager().nameTagSwitchingSetting * 16;

            if (getInstance().getSettingsManager().isOnServer()) {
                if (currentValue > chooseSeconds) {
                    return true;
                } else if (currentValue == 1) {
                    moveNameTags();
                } else {
                    updateCurrentNameTagRealTime();
                }

            }
        }

        return false;
    }
}
