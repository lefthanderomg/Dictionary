package andrey.murzin.com.feature_search

import andrey.murzin.com.feature_search.data.mapper.WordModelMapper
import andrey.murzin.com.network_api.model.MeaningModel
import andrey.murzin.com.network_api.model.WordModel
import org.junit.Test

class WordModelMapperTest {

    private val mapper: WordModelMapper = WordModelMapper()

    @Test
    fun `empty list`() {
        val result = mapper.toMeaningEntity(emptyList())
        assert(result.isEmpty())
    }

    @Test
    fun `meaning empty list`() {
        val result = mapper.toMeaningEntity(listOf(WordModel(0, emptyList(), "text")))
        assert(result.isEmpty())
    }

    @Test
    fun `word model null value`() {
        val result = mapper.toMeaningEntity(listOf(WordModel(null, null, null)))
        assert(result.isEmpty())
    }

    @Test
    fun `meaning model null value`() {
        val result = mapper.toMeaningEntity(
            listOf(
                WordModel(
                    1,
                    listOf(MeaningModel(null, null, null, null, null, null, null)),
                    ""
                )
            )
        )
        assert(result.size == 2)
    }
}