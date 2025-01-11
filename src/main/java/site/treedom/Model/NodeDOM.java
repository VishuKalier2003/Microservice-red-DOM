package site.treedom.Model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.treedom.Utility.ResponseData;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("dom")
public class NodeDOM {
    @Id
    private String id;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Node {
        @Nullable
        Node primaryChild;      // Primary descendant (if any)
        @Nullable
        List<Node> secondaryChildren = new ArrayList<>();       // Secondary descendants (if any)
        ResponseData store;         // Stores the dataKey and tag of current node
        boolean primaryNode;        // to check if current node is primary or not

        public Node(ResponseData data, boolean primary) {
            this.store = data;
            this.primaryNode = primary;
        }

        public Node(Node child, ResponseData data) {
            this.primaryChild = child;
            this.store = data;
        }
    }

    public Node head;
}
