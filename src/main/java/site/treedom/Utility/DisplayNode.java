package site.treedom.Utility;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DisplayNode {
    @NonNull private String dataKey, tag;
    @NonNull private boolean primaryNode;
}
