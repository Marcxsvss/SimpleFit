package jpasimplefit;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;
import jpasimplefit.Alimentos;
import jpasimplefit.DietaalimentoPK;
import jpasimplefit.Dietas;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-26T13:01:50", comments="EclipseLink-4.0.2.v20230616-r3bfa6ac6ddf76d7909adc5ea7ecaa47c02c007ed")
@StaticMetamodel(Dietaalimento.class)
@SuppressWarnings({"rawtypes", "deprecation"})
public class Dietaalimento_ { 

    public static volatile SingularAttribute<Dietaalimento, DietaalimentoPK> dietaalimentoPK;
    public static volatile SingularAttribute<Dietaalimento, Integer> cantidad;
    public static volatile SingularAttribute<Dietaalimento, Dietas> dietas;
    public static volatile SingularAttribute<Dietaalimento, Alimentos> alimentos;

}