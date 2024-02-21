package Collections

// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {
    val Products = customers.flatMap { it.getOrderedProducts() }.toSet()
    return customers.fold(Products)
    { orderedByAll, customer -> orderedByAll.intersect(customer.getOrderedProducts()) }
}

fun Customer.getOrderedProducts(): List<Product> =
    orders.flatMap { it.products }