package site.treedom.global;

import org.springframework.stereotype.Service;

import site.treedom.Model.Template;

@Service
public class Converter {
    // Converter for one Image Hero Section
    public void defineOneHero(Template webred, String dataKey, String heroLink, String heroTitle, String heroContent, String heroButton, String tag, boolean switchColor) {
        webred.setHeroLink(heroLink); webred.setDataKey(dataKey); webred.setHeroLink(heroLink); webred.setHeroTitle(heroTitle); webred.setHeroContent(heroContent); webred.setHeroButton(heroButton); webred.setTag(tag);
        webred.setOneHeroColorSwitch(switchColor);
        return;
    }

    // Converter for two Image Hero Section
    public void defineTwoHero(Template webred, String dataKey, String heroLink1, String heroLink2, String heroTitle, String heroContent, String heroButton, String tag, boolean switchColor) {
        webred.setDataKey(dataKey); webred.setHeroLink1(heroLink1); webred.setHeroLink2(heroLink2); webred.setHeroTitle(heroTitle);
        webred.setHeroContent(heroContent); webred.setHeroButton(heroButton); webred.setTag(tag); webred.setTwoColorSwitch(switchColor);
        return;
    }
}
