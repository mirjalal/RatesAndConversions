package aze.talmir.task.ratesconversions.data

import aze.talmir.task.ratesconversions.data.model.CurrencyData
import aze.talmir.task.ratesconversions.helpers.Result
import java.math.BigDecimal

class FakeRateConversionRepository :
    IRatesConversionsRepository {

    private var currencyDataServiceData = linkedMapOf<Int, CurrencyData>()

    override suspend fun getRates(
        base: String,
        coefficient: BigDecimal
    ): Result<Sequence<CurrencyData>> {
        return Result.Success(currencyDataServiceData.values.asSequence())
    }

    fun addCurrencyData(vararg currencyData: CurrencyData) {
        for (cd in currencyData)
            currencyDataServiceData[cd.id] = cd
    }
}
