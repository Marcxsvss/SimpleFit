package jpasimplefit;

import jakarta.persistence.metamodel.CollectionAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;
import jpasimplefit.Dietaalimento;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-26T13:01:50", comments="EclipseLink-4.0.2.v20230616-r3bfa6ac6ddf76d7909adc5ea7ecaa47c02c007ed")
@StaticMetamodel(Alimentos.class)
@SuppressWarnings({"rawtypes", "deprecation"})
public class Alimentos_ { 

    public static volatile SingularAttribute<Alimentos, Integer> calorias;
    public static volatile SingularAttribute<Alimentos, Integer> proteinas;
    public static volatile SingularAttribute<Alimentos, Integer> grasas;
    public static volatile SingularAttribute<Alimentos, Integer> carbohidratos;
    public static volatile CollectionAttribute<Alimentos, Dietaalimento> dietaalimentoCollection;
    public static volatile SingularAttribute<Alimentos, Integer> alimentoid;
    public static volatile SingularAttribute<Alimentos, String> nombre;

}