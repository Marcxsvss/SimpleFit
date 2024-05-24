package jpasimplefit;

import jakarta.persistence.metamodel.CollectionAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;
import jpasimplefit.Rutinamaquina;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-24T17:25:26", comments="EclipseLink-4.0.2.v20230616-r3bfa6ac6ddf76d7909adc5ea7ecaa47c02c007ed")
@StaticMetamodel(Maquinas.class)
@SuppressWarnings({"rawtypes", "deprecation"})
public class Maquinas_ { 

    public static volatile SingularAttribute<Maquinas, String> descripcion;
    public static volatile SingularAttribute<Maquinas, String> musculo;
    public static volatile CollectionAttribute<Maquinas, Rutinamaquina> rutinamaquinaCollection;
    public static volatile SingularAttribute<Maquinas, Integer> maquinaid;
    public static volatile SingularAttribute<Maquinas, String> imagen;
    public static volatile SingularAttribute<Maquinas, String> nombre;

}