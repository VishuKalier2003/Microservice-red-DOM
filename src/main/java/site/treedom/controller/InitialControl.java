package site.treedom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import site.treedom.Service.Initialization;
import site.treedom.Utility.ResponseData;

@RestController
@RequestMapping("dom/create")
public class InitialControl {
    @Autowired
    private Initialization initialization;

    @PostMapping("/primary")
    public ResponseEntity<Object> createPrimaryNode(@RequestParam String dataKey, @RequestParam String tag) {
        return ResponseEntity.ok().body(initialization.createPrimaryNode(new ResponseData(dataKey, tag)));
    }

    @PostMapping("/secondary")
    public ResponseEntity<Object> createSecondaryNode(@RequestParam String primaryKey, @RequestParam String dataKey, @RequestParam String tag) {
        return ResponseEntity.ok().body(initialization.createSecondaryNode(primaryKey, new ResponseData(dataKey, tag)));
    }
}
