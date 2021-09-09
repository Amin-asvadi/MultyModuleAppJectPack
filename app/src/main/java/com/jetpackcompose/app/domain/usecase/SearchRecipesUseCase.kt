package com.jetpackcompose.app.domain.usecase

import com.jetpackcompose.app.domain.model.Recipe
import com.jetpackcompose.app.network.mapper.RecipeDtoMapper
import com.jetpackcompose.app.network.repository.RecipeRepository
import javax.inject.Inject

interface SearchRecipesUseCase {
    suspend fun execute(page: Int, query: String): List<Recipe>
}

class SearchRecipesUseCaseImpl @Inject constructor(
    private val repository: RecipeRepository,
    private val mapper: RecipeDtoMapper
) : SearchRecipesUseCase {
    override suspend fun execute(page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(repository.search("todo", page, query).results ?: listOf())
    }
}