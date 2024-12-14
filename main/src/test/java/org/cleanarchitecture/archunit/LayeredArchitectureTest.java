package org.cleanarchitecture.archunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.cleanarchitecture.main.Application;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "org.cleanarchitecture..")
public class LayeredArchitectureTest {

    private static final String ENTITY_LAYER = "entity layer";
    private static final String USECASE_LAYER = "usecase layer";
    private static final String INFRASTRUCTURE_LAYER = "infrastructure layer";
    private static final String MAIN_LAYER = "main layer";

    @ArchTest
    static final ArchRule layer_dependencies_are_respected = layeredArchitecture().consideringAllDependencies()
            .layer(MAIN_LAYER).definedBy("org.cleanarchitecture.main..")
            .layer(ENTITY_LAYER).definedBy("org.cleanarchitecture.core.entity..")
            .layer(USECASE_LAYER).definedBy("org.cleanarchitecture.core.usecase..")
            .layer(INFRASTRUCTURE_LAYER).definedBy("org.cleanarchitecture.infrastructure..")

            .whereLayer(MAIN_LAYER).mayNotBeAccessedByAnyLayer()
            .whereLayer(ENTITY_LAYER).mayOnlyBeAccessedByLayers(USECASE_LAYER, INFRASTRUCTURE_LAYER)
            .whereLayer(USECASE_LAYER).mayOnlyBeAccessedByLayers(INFRASTRUCTURE_LAYER, MAIN_LAYER);

}