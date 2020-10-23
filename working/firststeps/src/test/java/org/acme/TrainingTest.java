package org.acme;

import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@QuarkusTest
public class TrainingTest {
    @InjectMock                                                             // (1)
    TrainingRepository repository;

    @Test
    public void testDataRepository() {
        // Mock a training
        Training training = new Training();
        training.name = training.name = "Quarkus Deep Dive";

        Mockito.when(repository.findById(10L)) .thenReturn(training);
        Mockito.when(repository.count()) .thenReturn(1L);
        Mockito.when(repository.listAll())
                .thenReturn(Arrays.asList(training));
        Mockito.when(repository
                .findByName("Quarkus Deep Dive"))                           // (2)
                .thenReturn(training);

        // Make assertions
        Assertions.assertSame(training, repository.findById(10L));
        Assertions.assertSame(repository.count(), 1L);
        Assertions.assertSame(repository.listAll().get(0), training);
        Assertions.assertSame(repository.findByName("Quarkus Deep Dive"),   // (3)
                training);
        Assertions.assertTrue("Quarkus Deep Dive!".equals(training.name));

        Mockito.verify(repository).count();                                 // (4)
        Mockito.verify(repository).listAll();
        Mockito.verify(repository).findById(Mockito.any());
        Mockito.verify(repository).findByName(Mockito.any());
    }

    @Test
    public void testActiveRecord() {
        PanacheMock.mock(Training.class);                             // (1)

        // Mock a training
        Training training = new Training();
        training.name ="Quarkus Deep Dive";
        Mockito.when(Training.findById(10L)).thenReturn(training);
        Mockito.when(Training.count()).thenReturn(1L);
        Mockito.when(Training.listAll())
                .thenReturn(Arrays.asList(training));

        // Make assertions
        Assertions.assertSame(training, Training.findById(10L));
        Assertions.assertSame(Training.listAll().size(), 1);
        Assertions.assertSame(Training.count(), 1L);
        Assertions.assertTrue("Quarkus Deep Dive!".equals(training.name)); // (2)

        PanacheMock.verify(Training.class).count();                   // (2)
        PanacheMock.verify(Training.class).listAll();
        PanacheMock.verify(Training.class,
                Mockito.atLeastOnce()).findById(Mockito.any());
    }
}

