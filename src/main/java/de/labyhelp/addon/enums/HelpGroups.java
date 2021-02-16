package de.labyhelp.addon.enums;

import de.labyhelp.addon.LabyHelp;
import net.minecraft.util.EnumChatFormatting;

public enum HelpGroups {

    USER("USER", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.GRAY + " " + LabyHelp.getInstance().getTranslationManager().getTranslation("rank.user"), false, false,false, false),
    BANNED("BANNED", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.GRAY + " " + LabyHelp.getInstance().getTranslationManager().getTranslation("rank.user"), false, false, false, false),

    FAME("FAME", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.YELLOW + " FAME", true, false, false, false),
    FAMOUS("FAMOUS", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.YELLOW + EnumChatFormatting.BOLD + " FAMOUS", false, true, false, false),
    INVITER("INVITER", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.AQUA + " " + LabyHelp.getInstance().getTranslationManager().getTranslation("rank.inviter"), true, false, false, false),

    BOOSTER("BOOSTER", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.LIGHT_PURPLE + "" + EnumChatFormatting.BOLD + " BOOSTER" + LabyHelp.getInstance().getTranslationManager().getTranslation("rank.booster"), false, true, false, false),

    PREMIUM("PREMIUM", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.DARK_AQUA + " Premium", true, true, false, false),
    DONATOR("DONATOR", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.YELLOW + "" + EnumChatFormatting.BOLD + " DONATOR", true, true, false, false),
    FRIEND("FRIEND", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.GOLD + " " + LabyHelp.getInstance().getTranslationManager().getTranslation("rank.friend"), true, true,false, true),
    PREMIUM_("PREMIUM_", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.YELLOW + "" + EnumChatFormatting.BOLD + " PREMIUM+", true, true, false, false),

    CREATOR("CREATOR", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.DARK_PURPLE + " "+ LabyHelp.getInstance().getTranslationManager().getTranslation("rank.creator"), true, true,false, true),
    LABYTEAM("LABYTEAM", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.BOLD + " LABYMOD " + EnumChatFormatting.BOLD + "TEAM", true,true, false, true),
    PARTNER("PARTNER", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.DARK_PURPLE + " " + LabyHelp.getInstance().getTranslationManager().getTranslation("rank.partner"), true, true,false, true),

    DESIGNER("DESIGNER", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.RED + " DESIGNER", true, true,false, true),
    SRDESIGNER("SRDESIGNER", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.GREEN + " SRDESIGNER", true, true,true, true),

    JRCONTENT("JRCONTENT", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.LIGHT_PURPLE + " CONTENT", true, true,false, true),
    CONTENT("CONTENT", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.LIGHT_PURPLE + " CONTENT", true, true,true, true),

    SRCONTENT("SRCONTENT", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.LIGHT_PURPLE + EnumChatFormatting.BOLD + " SRCONTENT", true,true, true, true),

    SUPPORTER("SUPPORTER", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.BLUE + " SUPPORTER", true, true,false, true),

    JRMODERATOR("JRMODERATOR", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.RED + " JRMODERATOR", true, true,false, true),
    MODERATOR("MODERATOR", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.RED + " MODERATOR", true, true,true, true),
    SRMODERATOR("SRMODERATOR", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.RED + EnumChatFormatting.BOLD + " SRMODERATOR", true,true, true, true),

    DEVELOPER("DEVELOPER", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.AQUA + " Developer", true, true,true, true),
    SRDEVELOPER("SRDEVELOPER", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "LabyHelp" + EnumChatFormatting.AQUA + EnumChatFormatting.BOLD + " SRDEVELOPER", true, true,true, true),

    ADMIN("ADMIN", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "" + "LabyHelp" + EnumChatFormatting.DARK_RED + EnumChatFormatting.BOLD +" ADMIN", true,true, true, true),
    OWNER("OWNER", EnumChatFormatting.WHITE + "" + EnumChatFormatting.BOLD + "" + "LabyHelp" + EnumChatFormatting.DARK_RED + EnumChatFormatting.BOLD + " CEO", true,true, true, true);


    private final String name, prefix;
    private final Boolean isPremium;
    private final Boolean isPremiumExtra;
    private final Boolean isTeam;
    private final Boolean showTag;

    HelpGroups(String name, String prefix, Boolean isPremium, Boolean isPremiumExtra, Boolean isTeam, Boolean showTag) {
        this.name = name;
        this.prefix = prefix;
        this.isPremium = isPremium;
        this.isPremiumExtra = isPremiumExtra;
        this.isTeam = isTeam;
        this.showTag = showTag;
    }

    public static Boolean isExist(final String name) {
        return HelpGroups.USER.getName().equalsIgnoreCase(name)
                || HelpGroups.PREMIUM.getName().equalsIgnoreCase(name) ||
                HelpGroups.FAME.getName().equalsIgnoreCase(name) ||
                HelpGroups.FAMOUS.getName().equalsIgnoreCase(name) ||
                HelpGroups.INVITER.getName().equalsIgnoreCase(name) ||
                HelpGroups.PREMIUM_.getName().equalsIgnoreCase(name) ||
                HelpGroups.BOOSTER.getName().equalsIgnoreCase(name) ||
                HelpGroups.DONATOR.getName().equalsIgnoreCase(name) ||
                HelpGroups.FRIEND.getName().equalsIgnoreCase(name) ||
                HelpGroups.BANNED.getName().equalsIgnoreCase(name) ||
                HelpGroups.CREATOR.getName().equalsIgnoreCase(name) ||
                HelpGroups.SUPPORTER.getName().equalsIgnoreCase(name) ||
                HelpGroups.LABYTEAM.getName().equalsIgnoreCase(name) ||
                HelpGroups.PARTNER.getName().equalsIgnoreCase(name) ||
                HelpGroups.DESIGNER.getName().equalsIgnoreCase(name) ||
                HelpGroups.SRDESIGNER.getName().equalsIgnoreCase(name) ||
                HelpGroups.JRCONTENT.getName().equalsIgnoreCase(name) ||
                HelpGroups.CONTENT.getName().equalsIgnoreCase(name) ||
                HelpGroups.SRCONTENT.getName().equalsIgnoreCase(name) ||
                HelpGroups.JRMODERATOR.getName().equalsIgnoreCase(name) ||
                HelpGroups.MODERATOR.getName().equalsIgnoreCase(name) ||
                HelpGroups.SRMODERATOR.getName().equalsIgnoreCase(name) ||
                HelpGroups.DEVELOPER.getName().equalsIgnoreCase(name) ||
                HelpGroups.SRDEVELOPER.getName().equalsIgnoreCase(name) ||
                HelpGroups.ADMIN.getName().equalsIgnoreCase(name) ||
                HelpGroups.OWNER.getName().equalsIgnoreCase(name);
    }


    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public Boolean getPremium() {
        return isPremium;
    }

    public Boolean getTeam() {
        return isTeam;
    }

    public Boolean getTag() {
        return showTag;
    }


    public Boolean getPremiumExtra() {
        return isPremiumExtra;
    }
}
