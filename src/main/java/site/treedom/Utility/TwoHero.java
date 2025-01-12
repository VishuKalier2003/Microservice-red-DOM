package site.treedom.Utility;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwoHero {
    @NonNull private String dataKey;
    @Nullable private String heroLink1, heroLink2, heroTitle, heroContent, heroButton, customName, tag;
    private boolean colorSwitch;
}
