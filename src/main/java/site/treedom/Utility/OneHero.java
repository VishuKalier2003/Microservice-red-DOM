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
public class OneHero {
    // Imp- Hero section types with only One Image link
    @NonNull private String dataKey;
    @Nullable private String heroLink, heroTitle, heroContent, heroButton, customName;
    @Nullable private String tag;
    private boolean colorSwitch;
}
