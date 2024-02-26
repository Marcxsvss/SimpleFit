package jpasimplefit;

import jakarta.persistence.metamodel.CollectionAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;
import jpasimplefit.Dietaalimento;
import jpasimplefit.Users;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-26T13:01:50", comments="EclipseLink-4.0.2.v20230616-r3bfa6ac6ddf76d7909adc5ea7ecaa47c02c007ed")
@StaticMetamodel(Dietas.class)
@SuppressWarnings({"rawtypes", "deprecation"})
public class Dietas_ { 

    public static volatile SingularAttribute<Dietas, String> descripcion;
    public static volatile SingularAttribute<Dietas, String> objetivo;
    public static volatile SingularAttribute<Dietas, Integer> calorias;
    public static volatile SingularAttribute<Dietas, Integer> dietaid;
    public static volatile SingularAttribute<Dietas, Integer> duracion;
    public static volatile CollectionAttribute<Dietas, Dietaalimento> dietaalimentoCollection;
    public static volatile SingularAttribute<Dietas, String> nombre;
    public static volatile SingularAttribute<Dietas, Users> userid;

}