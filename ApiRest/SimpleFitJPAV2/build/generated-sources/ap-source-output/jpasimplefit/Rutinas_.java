package jpasimplefit;

import jakarta.persistence.metamodel.CollectionAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;
import jpasimplefit.Rutinamaquina;
import jpasimplefit.Usuarios;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-24T17:25:26", comments="EclipseLink-4.0.2.v20230616-r3bfa6ac6ddf76d7909adc5ea7ecaa47c02c007ed")
@StaticMetamodel(Rutinas.class)
@SuppressWarnings({"rawtypes", "deprecation"})
public class Rutinas_ { 

    public static volatile SingularAttribute<Rutinas, String> descripcion;
    public static volatile SingularAttribute<Rutinas, Integer> frecuencia;
    public static volatile CollectionAttribute<Rutinas, Rutinamaquina> rutinamaquinaCollection;
    public static volatile CollectionAttribute<Rutinas, Usuarios> usuariosCollection;
    public static volatile SingularAttribute<Rutinas, String> titulo;
    public static volatile SingularAttribute<Rutinas, Integer> rutinaid;
    public static volatile SingularAttribute<Rutinas, Integer> diasdescanso;
    public static volatile SingularAttribute<Rutinas, String> dificultad;

}