package pl.sdacademy.unit.test.advance.exercises.task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {

    private static final Long CAT_ID = 1L;
    private static final String CAT_TYPE = "Cat";
    private static final String CAT_NAME = "Filemon";

    private static final Animal ANIMAL = new Animal(CAT_ID, CAT_TYPE, CAT_NAME);

    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AnimalService animalService;

    @Test
    void shouldReturnAnimalById() {
        // given
        Mockito.when(animalRepository.findAnimalById(any())).thenReturn(Optional.of(ANIMAL));
        // when
        Animal result = animalService.getAnimalById(CAT_ID);
        //then
        assertThat(result).isEqualTo(ANIMAL);
//        verify(animalRepository).findAnimalById(CAT_ID);
    }

    @Test
    void shouldThrowExceptionIfAnimalDoesNotExist() {
        // given
        Long notExistingAnimalId = CAT_ID + 1;
        Mockito.when(animalRepository.findAnimalById(notExistingAnimalId))
                .thenReturn(Optional.empty());
        // when & then
        assertThatThrownBy(() -> animalService.getAnimalById(notExistingAnimalId))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("animal not exist with id: " + notExistingAnimalId);
//        verifyNoMoreInteractions(animalRepository);
    }

    @Test
    void shouldAddAnimalToRepository() {
        // given
        Mockito.when(animalRepository.addAnimal(any())).thenReturn(ANIMAL);
        // when
        Animal result = animalService.addAnimalToRepository(CAT_TYPE, CAT_NAME);
        // then
        assertThat(result).isEqualTo(ANIMAL);
    }

}