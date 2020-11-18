package com.qa.ims.persistence.domain;

public class Orders {

	private Long order_id;
	private Long customer_id;
	private Long orderitem_id;
	private Long product_id;
	private Long order_quantity;
	private Double total_cost;
	
	
	// super maybe messing up 
	public Orders(Long customer_id) {
		super();
		this.customer_id = customer_id;
	}

	public Orders(Long order_id, Long product_id, Long order_quantity) {
		super();
		this.order_id = order_id;
		this.product_id = product_id;
		this.order_quantity = order_quantity;
	}



	public Orders(Long order_id, Long customer_id, Long orderitem_id, Long product_id, Long order_quantity,
			Double total_cost) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.orderitem_id = orderitem_id;
		this.product_id = product_id;
		this.order_quantity = order_quantity;
		this.total_cost = total_cost;	
	}
	
	
	public Orders(Long customer_id, Long orderitem_id, Long product_id, Long order_quantity, Double total_cost) {
		super();
		this.customer_id = customer_id;
		this.orderitem_id = orderitem_id;
		this.product_id = product_id;
		this.order_quantity = order_quantity;
		this.total_cost = total_cost;
	}

	

	public Orders(Long order_id, Long customer_id) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
	}
	

	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public Long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public Long getOrderitem_id() {
		return orderitem_id;
	}
	public void setOrderitem_id(Long orderitem_id) {
		this.orderitem_id = orderitem_id;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public Long getOrder_quantity() {
		return order_quantity;
	}
	public void setOrder_quantity(Long order_quantity) {
		this.order_quantity = order_quantity;
	}
	public Double getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(Double total_cost) {
		this.total_cost = total_cost;
	}


	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", customer_id=" + customer_id + ", orderitem_id=" + orderitem_id
				+ ", product_id=" + product_id + ", order_quantity=" + order_quantity + ", total_cost=" + total_cost
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (customer_id == null) {
			if (other.customer_id !=null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (orderitem_id == null) {
			if (other.orderitem_id != null)
				return false;
		} else if (!orderitem_id.equals(other.orderitem_id))
				return false;
		if (order_quantity == null) {
			if (other.order_quantity != null)
				return false;
		} else if (!order_quantity.equals(other.order_quantity))
				return false;
		if (total_cost == null) {
			if (other.total_cost != null)
				return false;
		} else if (!total_cost.equals(other.total_cost))
				return false;
			if (product_id == null) {
				if (other.product_id != null)
					return false;
		} else if (!product_id.equals(other.product_id))
				return false;
			return true;
		}
}
