package com.paddle;

import com.paddle.address.AddressResource;
import com.paddle.business.BusinessResource;
import com.paddle.customer.CustomerResource;
import com.paddle.discount.DiscountResource;
import com.paddle.http.HTTPConfig;
import com.paddle.price.PriceResource;
import com.paddle.product.ProductResource;
import com.paddle.subscription.SubscriptionResource;
import com.paddle.transaction.TransactionResource;

public class PaddleClient {

  private final HTTPConfig config;

  public PaddleClient(HTTPConfig config) {
    this.config = config;
  }

  public CustomerResource customers() {
    return new CustomerResource(this.config);
  }

  public AddressResource addresses() {
    return new AddressResource(this.config);
  }

  public BusinessResource businesses() {
    return new BusinessResource(this.config);
  }

  public ProductResource products() {
    return new ProductResource(this.config);
  }

  public PriceResource prices() {
    return new PriceResource(this.config);
  }

  public DiscountResource discounts() {
    return new DiscountResource(this.config);
  }

  public SubscriptionResource subscriptions() {
    return new SubscriptionResource(this.config);
  }

  public TransactionResource transactions() {
    return new TransactionResource(this.config);
  }
}
