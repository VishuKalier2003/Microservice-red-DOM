package site.treedom.Utility;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {
    //! Use these for referencing of every component in WorkArea
    @NonNull
    private String dataKey, tag;
    @Nullable private String customName;

    public ResponseData(String data, String t) {
        this.dataKey = data; this.tag = t;
    }
}
