package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryTest extends TestCase {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setup() throws Exception{

    }

    @Test
//    @DirtiesContext (o sa restarteze Spring env)
    public void testFindByDescription() {

        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        assertEquals("Teaspoon", teaspoon.get().getDescription());
    }

    @Test
    public void testFindByDescriptionCup() {

        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Cup");
        assertEquals("Cup", teaspoon.get().getDescription());
    }
}