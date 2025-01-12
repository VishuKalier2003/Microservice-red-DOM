package site.treedom.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.treedom.Model.Template;
import site.treedom.Repository.TemplateRepo;
import site.treedom.Utility.OneHero;
import site.treedom.Utility.TwoHero;
import site.treedom.global.Converter;

@Service
public class Templating {
    @Autowired
    private TemplateRepo templateRepo;
    @Autowired
    private Converter converter;

    public String createAndConvertOneHero(OneHero oneHero) {
        Template template = new Template();
        String dataKey = oneHero.getDataKey(), heroLink = oneHero.getHeroLink(), heroTitle = oneHero.getHeroTitle();
        String heroContent = oneHero.getHeroContent(), heroButton = oneHero.getHeroButton(), tag = oneHero.getTag();
        boolean switchValue = oneHero.isColorSwitch();
        converter.defineOneHero(template, dataKey, heroLink, heroTitle, heroContent, heroButton, tag, switchValue);
        templateRepo.save(template);
        return dataKey;
    }

    public String createAndConvertTwoHero(TwoHero twoHero) {
        Template template = new Template();
        String dataKey = twoHero.getDataKey(), heroLink1 = twoHero.getHeroLink1(), heroLink2 = twoHero.getHeroLink2();
        String title = twoHero.getHeroTitle(), content = twoHero.getHeroContent(), button = twoHero.getHeroButton();
        String tag = twoHero.getTag();
        boolean switchValue = twoHero.isColorSwitch();
        converter.defineTwoHero(template, dataKey, heroLink1, heroLink2, title, content, button, tag, switchValue);
        templateRepo.save(template);
        return dataKey;
    }

    public List<Template> findAllTemplates() {
        return templateRepo.findAll();
    }

    public String deleteTemplate(String dataKey) {
        templateRepo.deleteById(dataKey);
        return dataKey;
    }

    public String deleteAllTemplates() {
        templateRepo.deleteAll();
        return "All cleared";
    }
}
