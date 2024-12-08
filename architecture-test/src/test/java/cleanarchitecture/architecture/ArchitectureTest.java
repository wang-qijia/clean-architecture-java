package cleanarchitecture.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "org.cleanarchitecture..")
public abstract class ArchitectureTest {

}