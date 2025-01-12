package site.treedom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import site.treedom.Service.Traversal;
import site.treedom.Utility.ResponseData;

@RestController
@RequestMapping("dom/search")
public class SearchControl {
    @Autowired
    private Traversal traversal;

    @GetMapping("/nodeByEntry")
    public ResponseEntity<Object> searchNodeByEntry(@RequestParam String dataKey) {
        return ResponseEntity.ok().body(traversal.searchOfTypeNode(dataKey));
    }

    @GetMapping("/nodeByEntry/data")
    public ResponseEntity<Object> getNodeData(@RequestParam String dataKey) {
        return ResponseEntity.ok().body(traversal.searchOfTypeNodeGetResponseData(dataKey));
    }

    @GetMapping("/nodeByEntry/tag")
    public ResponseEntity<String> getTagData(@RequestParam String dataKey){
        return ResponseEntity.ok().body(traversal.searchOfTypeNodeGetTag(dataKey));
    }


    @GetMapping("/nodeByEntry/parent")
    public ResponseEntity<Object> getNodeParent(@RequestParam String dataKey) {
        return ResponseEntity.ok().body(traversal.searchOfTypeNodeParent(dataKey));
    }

    @GetMapping("/nodeByEntry/primaryIdentifier")
    public ResponseEntity<Object> getNodeIdentifier(@RequestParam String dataKey) {
        return ResponseEntity.ok().body(traversal.searchOfTypeNodeIsPrimary(dataKey));
    }

    @GetMapping("/nodeByEntry/check")
    public ResponseEntity<Object> searchNodeEntry(@RequestParam String dataKey) {
        return ResponseEntity.ok().body(traversal.searchOfTypeBoolean(dataKey));
    }

    @GetMapping("/node")
    public ResponseEntity<Object> searchUsingNodeData(@RequestBody ResponseData responseData) {
        return ResponseEntity.ok().body(traversal.searchOfTypeBooleanWithResponseData(responseData));
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllList() {
        return ResponseEntity.ok().body(traversal.levelOrder());
    }
}
