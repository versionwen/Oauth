package version.po;

/**
 * @author version
 * @version 1.0
 * @date 2020/4/4 18:35
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author version
 * @version 1.0
 * @date 2020/4/4 17:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUser {
    private static final long serialVersionUID = 3497935890426858541L;

    private String userName;
    private String password;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked= true;
    private boolean credentialsNonExpired= true;
    private boolean enabled= true;
}

