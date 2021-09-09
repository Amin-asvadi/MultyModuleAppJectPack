package com.jetpackcompose.app.domain.usecase

import com.jetpackcompose.app.domain.model.Recipe
import com.jetpackcompose.app.network.mapper.RecipeDtoMapper
import com.jetpackcompose.app.network.repository.RecipeRepository
import javax.inject.Inject

interface GetRecipeByIdUseCase {
    suspend fun execute(id: Int): Recipe
}

class GetRecipeByIdUseCaseImpl @Inject constructor(
    private val repository: RecipeRepository,
    private val mapper: RecipeDtoMapper
) : GetRecipeByIdUseCase {
    override suspend fun execute(id: Int): Recipe {
        return mapper.mapToDomainModel(repository.getRecipeById("todo", id))
    }
}