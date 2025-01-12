package site.treedom.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("template")
public class Template {
    @Id
    private String dataKey; // The dataKey (uuid) of the document
    @Nullable // Stores the entries as per constructors
    private String customName, heroLink, heroTitle, heroContent, heroButton, heroLink1, heroLink2;
    private boolean oneHeroColorSwitch;
    private boolean twoColorSwitch;
    @NonNull
    private String tag; // Tag to store the component type
}
