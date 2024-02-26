package jpasimplefit;

import jakarta.persistence.metamodel.CollectionAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;
import jpasimplefit.Dietas;
import jpasimplefit.Rutinas;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-26T13:01:50", comments="EclipseLink-4.0.2.v20230616-r3bfa6ac6ddf76d7909adc5ea7ecaa47c02c007ed")
@StaticMetamodel(Users.class)
@SuppressWarnings({"rawtypes", "deprecation"})
public class Users_ { 

    public static volatile SingularAttribute<Users, Integer> altura;
    public static volatile CollectionAttribute<Users, Rutinas> rutinasCollection;
    public static volatile CollectionAttribute<Users, Dietas> dietasCollection;
    public static volatile SingularAttribute<Users, String> sexo;
    public static volatile SingularAttribute<Users, String> nombre;
    public static volatile SingularAttribute<Users, Integer> edad;
    public static volatile SingularAttribute<Users, Integer> dni;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> alergias;

}