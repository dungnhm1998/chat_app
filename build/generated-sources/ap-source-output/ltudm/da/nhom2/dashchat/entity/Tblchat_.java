package ltudm.da.nhom2.dashchat.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-11T12:39:41")
@StaticMetamodel(Tblchat.class)
public class Tblchat_ { 

    public static volatile SingularAttribute<Tblchat, Integer> chatID;
    public static volatile SingularAttribute<Tblchat, Integer> receiver;
    public static volatile SingularAttribute<Tblchat, Integer> sender;
    public static volatile SingularAttribute<Tblchat, Date> time;
    public static volatile SingularAttribute<Tblchat, String> type;
    public static volatile SingularAttribute<Tblchat, String> content;

}