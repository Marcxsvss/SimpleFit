package jpasimplefit;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;
import jpasimplefit.Maquinas;
import jpasimplefit.RutinamaquinaPK;
import jpasimplefit.Rutinas;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-24T17:25:26", comments="EclipseLink-4.0.2.v20230616-r3bfa6ac6ddf76d7909adc5ea7ecaa47c02c007ed")
@StaticMetamodel(Rutinamaquina.class)
@SuppressWarnings({"rawtypes", "deprecation"})
public class Rutinamaquina_ { 

    public static volatile SingularAttribute<Rutinamaquina, Rutinas> rutinas;
    public static volatile SingularAttribute<Rutinamaquina, RutinamaquinaPK> rutinamaquinaPK;
    public static volatile SingularAttribute<Rutinamaquina, Maquinas> maquinas;

}