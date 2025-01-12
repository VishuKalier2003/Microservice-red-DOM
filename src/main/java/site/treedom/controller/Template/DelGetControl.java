package site.treedom.controller.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import site.treedom.Service.Templating;

@RestController
@RequestMapping("template/delete")
public class DelGetControl {
    @Autowired
    private Templating templating;

    @DeleteMapping("/clear")
    public ResponseEntity<String> deleteByDataKey(@RequestParam String dataKey) {
        return ResponseEntity.ok().body(templating.deleteTemplate(dataKey));
    }

    @DeleteMapping("/clear/delete/all")
    public ResponseEntity<String> deleteAll() {
        return ResponseEntity.ok().body(templating.deleteAllTemplates());
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllTemplates() {
        return ResponseEntity.ok().body(templating.findAllTemplates());
    }
}
