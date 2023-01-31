package pl.sdacademy.unit.test.advance.exercises.task2;

import java.util.concurrent.atomic.AtomicLong;

public class AnimalService {

    private AnimalRepository animalRepository;

    private static AtomicLong idCounter = new AtomicLong();

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.findAnimalById(id)
                .orElseThrow(() -> new IllegalArgumentException("animal not exist with id: " + id));
    }

    public Animal addAnimalToRepository(String type, String name) {
        return animalRepository.addAnimal(new Animal(idCounter.getAndIncrement(), type, name));
    }
}
