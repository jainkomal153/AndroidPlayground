package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

private const val PRICE_PER_CUPCAKE = 2.00
private const val PRICE_FOR_SAME_DAY_PICKUP = 3.00
class OrderViewModel: ViewModel() {

    private val _quantity = MutableLiveData<Int>()
    val quantity : LiveData<Int> = _quantity
    private val _flavor = MutableLiveData<String>()
    val flavor : LiveData<String> = _flavor
    private val _pickupDate = MutableLiveData<String>()
    val pickupDate: LiveData<String> = _pickupDate
    private val _price = MutableLiveData<Double>()
    val price : LiveData<String> = Transformations.map(_price){
        NumberFormat.getCurrencyInstance().format(it)
    }
    val dateOptions = getDate()

    init {
        resetOrder()
    }
    fun setQuantity(numberCupcakes: Int){
        _quantity.value = numberCupcakes
        updatePrice()
    }
    fun setFlavor(desiredFlavor: String){
        _flavor.value = desiredFlavor
    }
    fun setDate(pickupDate: String){
        _pickupDate.value = pickupDate
        updatePrice()
    }
    fun hasNoFlavorSet(): Boolean{
        return _flavor.value.isNullOrEmpty()
    }
    fun getDate(): List<String>{
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calender = Calendar.getInstance()
        repeat(4){
            options.add(formatter.format(calender.time))
            calender.add(Calendar.DATE,1)
        }
        return options
    }
    fun resetOrder(){
        _quantity.value =0
        _flavor.value =""
        _pickupDate.value = dateOptions[0]
        _price.value=0.0
    }

    private fun updatePrice(){
        _price.value = (_quantity.value ?:0).times(PRICE_PER_CUPCAKE)
        if(_pickupDate.value.equals(dateOptions[0])){
            _price.value = _price.value?.plus(PRICE_FOR_SAME_DAY_PICKUP)
        }
    }

}