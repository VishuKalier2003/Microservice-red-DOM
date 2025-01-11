package site.treedom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import site.treedom.Service.Deletion;

@RestController
@RequestMapping("dom/delete")
public class DeleteControl {
    @Autowired
    private Deletion deletion;

    @DeleteMapping("/nodeByEntry")
    public ResponseEntity<Object> deleteCurrentData(@RequestParam String dataKey) {
        return ResponseEntity.ok().body(deletion.deleteNode(dataKey));
    }

    @DeleteMapping("/all")
    public ResponseEntity<Object> deleteAllNodes() {
        return ResponseEntity.ok().body(deletion.clearAllNodes());
    }
}
