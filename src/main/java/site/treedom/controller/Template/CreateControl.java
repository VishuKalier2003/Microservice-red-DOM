package site.treedom.controller.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import site.treedom.Service.Templating;
import site.treedom.Utility.OneHero;
import site.treedom.Utility.TwoHero;

@RestController
@RequestMapping("template/create")
public class CreateControl {
    @Autowired
    private Templating templating;

    @PostMapping("/one-hero")
    public ResponseEntity<Object> createAndSaveOneHeroTemplate(@RequestBody OneHero oneHero) {
        return ResponseEntity.ok().body(templating.createAndConvertOneHero(oneHero));
    }

    @PostMapping("/two-hero")
    public ResponseEntity<Object> createAndSaveTwoHeroTemplate(@RequestBody TwoHero twoHero) {
        return ResponseEntity.ok().body(templating.createAndConvertTwoHero(twoHero));
    }
}
