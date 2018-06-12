package com.ngockhuong.identity.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;

public class Social {
    private String facebook;
    private String instagram;
    private String linkedln;
    private String pinterest;
    private String twitter;
    private String googleplus;
    private String youtube;
    private String github;
    private String tumblr;
    private String flickr;
    private String reddit;
    private String quora;
    private String whatsApp;
    private String zalo;
    private String viber;
    private String line;
    private String telegram;
    private String skype;

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getLinkedln() {
        return linkedln;
    }

    public void setLinkedln(String linkedln) {
        this.linkedln = linkedln;
    }

    public String getPinterest() {
        return pinterest;
    }

    public void setPinterest(String pinterest) {
        this.pinterest = pinterest;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getGoogleplus() {
        return googleplus;
    }

    public void setGoogleplus(String googleplus) {
        this.googleplus = googleplus;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getTumblr() {
        return tumblr;
    }

    public void setTumblr(String tumblr) {
        this.tumblr = tumblr;
    }

    public String getFlickr() {
        return flickr;
    }

    public void setFlickr(String flickr) {
        this.flickr = flickr;
    }

    public String getReddit() {
        return reddit;
    }

    public void setReddit(String reddit) {
        this.reddit = reddit;
    }

    public String getQuora() {
        return quora;
    }

    public void setQuora(String quora) {
        this.quora = quora;
    }

    public String getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }

    public String getZalo() {
        return zalo;
    }

    public void setZalo(String zalo) {
        this.zalo = zalo;
    }

    public String getViber() {
        return viber;
    }

    public void setViber(String viber) {
        this.viber = viber;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    @Override
    public String toString() {
        return "Social{" +
                "facebook='" + facebook + '\'' +
                ", instagram='" + instagram + '\'' +
                ", linkedln='" + linkedln + '\'' +
                ", pinterest='" + pinterest + '\'' +
                ", twitter='" + twitter + '\'' +
                ", googleplus='" + googleplus + '\'' +
                ", youtube='" + youtube + '\'' +
                ", github='" + github + '\'' +
                ", tumblr='" + tumblr + '\'' +
                ", flickr='" + flickr + '\'' +
                ", reddit='" + reddit + '\'' +
                ", quora='" + quora + '\'' +
                ", whatsApp='" + whatsApp + '\'' +
                ", zalo='" + zalo + '\'' +
                ", viber='" + viber + '\'' +
                ", line='" + line + '\'' +
                ", telegram='" + telegram + '\'' +
                ", skype='" + skype + '\'' +
                '}';
    }

    public String toFormList() {
        return "facebook : '" + ((facebook != null) ? facebook : "") + "'" +
                "\ninstagram : '" + ((instagram != null) ? instagram : "") + "'" +
                "\nlinkedln : '" + ((linkedln != null) ? linkedln : "") + "'" +
                "\npinterest : '" + ((pinterest != null) ? pinterest : "") + "'" +
                "\ntwitter : '" + ((twitter != null) ? twitter : "") + "'" +
                "\ngoogleplus : '" + ((googleplus != null) ? googleplus : "") + "'" +
                "\nyoutube : '" + ((youtube != null) ? youtube : "") + "'" +
                "\ngithub : '" + ((github != null) ? github : "") + "'" +
                "\ntumblr : '" + ((tumblr != null) ? tumblr : "") + "'" +
                "\nflickr : '" + ((flickr != null) ? flickr : "") + "'" +
                "\nreddit : '" + ((reddit != null) ? reddit : "") + "'" +
                "\nquora : '" + ((quora != null) ? quora : "") + "'" +
                "\nwhatsApp : '" + ((whatsApp != null) ? whatsApp : "") + "'" +
                "\nzalo : '" + ((zalo != null) ? zalo : "") + "'" +
                "\nviber : '" + ((viber != null) ? viber : "") + "'" +
                "\nline : '" + ((line != null) ? line : "") + "'" +
                "\ntelegram : '" + ((telegram != null) ? telegram : "") + "'" +
                "\nskype : '" + ((skype != null) ? skype : "") + "'";
    }

    public void getFromProperties(String data) throws IOException {
        Properties properties = new Properties();
        properties.load(new ByteArrayInputStream(data.getBytes()));

        facebook = properties.getProperty("facebook");
        instagram = properties.getProperty("instagram");
        linkedln = properties.getProperty("linkedln");
        pinterest = properties.getProperty("pinterest");
        twitter = properties.getProperty("twitter");
        googleplus = properties.getProperty("googleplus");
        youtube = properties.getProperty("youtube");
        github = properties.getProperty("github");
        tumblr = properties.getProperty("tumblr");
        flickr = properties.getProperty("flickr");
        reddit = properties.getProperty("reddit");
        quora = properties.getProperty("quora");
        whatsApp = properties.getProperty("whatsApp");
        zalo = properties.getProperty("zalo");
        viber = properties.getProperty("viber");
        line = properties.getProperty("line");
        telegram = properties.getProperty("telegram");
        skype = properties.getProperty("skype");
    }
}
