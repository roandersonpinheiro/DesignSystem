package com.roanderson.design_compose.utils

import kotlin.random.Random

class Gene(val value: Int)

class Individual(val genes: List<Gene>) {
    fun calculateFitness(target: Int): Int {
        val sum = genes.sumBy { it.value }
        return Math.abs(target - sum)
    }
}

class GeneticAlgorithm(val target: Int, val populationSize: Int, val geneSize: Int, val mutationRate: Double) {
    private fun generateRandomGene(): Gene {
        return Gene(Random.nextInt(2))
    }

    private fun generateRandomIndividual(): Individual {
        val genes = List(geneSize) { generateRandomGene() }
        return Individual(genes)
    }

    private fun crossover(parent1: Individual, parent2: Individual): Individual {
        val crossoverPoint = Random.nextInt(geneSize)
        val newGenes = parent1.genes.subList(0, crossoverPoint) + parent2.genes.subList(crossoverPoint, geneSize)
        return Individual(newGenes)
    }

    private fun mutate(individual: Individual) {
        for (gene in individual.genes) {
            if (Random.nextDouble() < mutationRate) {
                gene.value = 1 - gene.value
            }
        }
    }

    fun evolve(generations: Int) {
        var population = List(populationSize) { generateRandomIndividual() }

        for (generation in 0 until generations) {
            val sortedPopulation = population.sortedBy { it.calculateFitness(target) }
            val newPopulation = mutableListOf<Individual>()

            for (i in 0 until populationSize / 2) {
                val parent1 = sortedPopulation[i]
                val parent2 = sortedPopulation[i + 1]
                val child = crossover(parent1, parent2)
                mutate(child)
                newPopulation.add(child)
            }

            population = newPopulation
        }

        val bestIndividual = population.minByOrNull { it.calculateFitness(target) }
        println("Best individual's genes: ${bestIndividual?.genes}")
    }
}

fun main() {
    val target = 50
    val populationSize = 100
    val geneSize = 10
    val mutationRate = 0.01
    val generations = 100

    val ga = GeneticAlgorithm(target, populationSize, geneSize, mutationRate)
    ga.evolve(generations)
}
