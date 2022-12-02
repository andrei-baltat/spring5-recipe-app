package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecipeServiceImplTest{

    RecipeServiceImpl service;

    @Mock
    RecipeRepository repository;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        service = new RecipeServiceImpl(repository);
    }

    @Test
    public void testGetRecipes() {
        Set<Recipe> recipesData = new HashSet<>();
        recipesData.add(Recipe.builder().id(1L).build());
        recipesData.add(Recipe.builder().id(2L).build());

        when(repository.findAll()).thenReturn(recipesData);
        Set<Recipe> recipes = service.getRecipes();
        verify(repository, times(1)).findAll();
        assertEquals(recipes.size(), 2);
    }
}