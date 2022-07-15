package com.ydlclass.provider.domain;
import java.io.Serializable;

public class Goods implements Serializable {
        private Integer id;
        private String title;
        private double price;
        private Integer stock;

        public Goods() {

        }
        public Goods(Integer id, String title, double price, Integer stock) {
            this.id = id;
            this.title = title;
            this.price = price;
            this.stock = stock;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public Integer getStock() {
            return stock;
        }

        public void setStock(Integer stock) {
            this.stock = stock;
        }

        @Override
        public String toString() {
            return "Goods{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", price=" + price +
                    ", stock=" + stock +
                    '}';
        }
}
