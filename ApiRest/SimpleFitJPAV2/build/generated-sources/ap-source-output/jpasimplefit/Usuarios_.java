package jpasimplefit;

import jakarta.persistence.metamodel.CollectionAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;
import jpasimplefit.Rutinas;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-24T17:25:26", comments="EclipseLink-4.0.2.v20230616-r3bfa6ac6ddf76d7909adc5ea7ecaa47c02c007ed")
@StaticMetamodel(Usuarios.class)
@SuppressWarnings({"rawtypes", "deprecation"})
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, Integer> rutinastate;
    public static volatile SingularAttribute<Usuarios, String> password;
    public static volatile SingularAttribute<Usuarios, String> somatotipo;
    public static volatile SingularAttribute<Usuarios, String> foto;
    public static volatile SingularAttribute<Usuarios, String> peso;
    public static volatile SingularAttribute<Usuarios, String> altura;
    public static volatile CollectionAttribute<Usuarios, Rutinas> rutinasCollection;
    public static volatile SingularAttribute<Usuarios, Integer> acceso;
    public static volatile SingularAttribute<Usuarios, String> sexo;
    public static volatile SingularAttribute<Usuarios, String> nombre;
    public static volatile SingularAttribute<Usuarios, String> edad;
    public static volatile SingularAttribute<Usuarios, String> email;

}