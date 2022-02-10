<template>
  <table border="1" width="100%" align="right">
    <tr v-for="item in basket.basketItems" :key="item.id">
      <td align="center">
        <img
          width="200"
          :src="`images/${item.clay.image}`"
          :alt="`${item.clay.name}`"
          border="0"
        />
      </td>

      <td>
        <table>
          <tr>
            <td align="right">Поставщики:</td>
            <td>
              <li v-for="supplier in item.clay.suppliers" :key="supplier.id">
                {{ supplier.name }}
              </li>
            </td>
          </tr>
          <tr>
            <td align="right">Название:</td>
            <td>{{ item.clay.name }}</td>
          </tr>
          <tr>
            <td align="right">Категория:</td>
            <td>{{ item.clay.category.name }}</td>
          </tr>
          <tr>
            <td align="right">Цена:</td>
            <td>{{ item.clay.price }}</td>
          </tr>
          <tr>
            <td align="right">Масса:</td>
            <td>{{ item.clay.weight }}</td>
          </tr>
        </table>
      </td>
      <td>
        Количество: {{ item.count }}
        <br />
        <button v-on:click="addToBasket(item.clay.id)">Добавить</button>
        <button v-on:click="removeFromBasket(item.clay.id)">Убрать</button>
      </td>
    </tr>
  </table>
  Сумма: {{ getPrice() }}
  <br />
  <button v-on:click="order">Заказать</button>
</template>

<script>
  import service from "../domain/clayMarketService.js";
  import authService from "../domain/keycloak.js";

  export default {
    data() {
      return {
        basket: {},
      };
    },
    async beforeCreate() {
      await authService.login(this.$router.currentRoute.value.fullPath);
      this.basket = await service.getBasket();
    },
    methods: {
      async addToBasket(id) {
        if (await service.addToBasket(id)) {
          this.basket.basketItems.forEach((element) => {
            if (element.clay.id == id) {
              element.count++;
            }
          });
        }
      },
      async removeFromBasket(id) {
        if (await service.removeFromBasket(id)) {
          this.basket.basketItems.forEach((element) => {
            if (element.clay.id == id) {
              element.count--;
            }
          });
        }
      },
      async order() {
        if (await service.orderBasket()) {
          this.$router.push("/");
        }
      },
      getPrice() {
        var sum = 0;
        if (this.basket.basketItems) {
          this.basket.basketItems.forEach((element) => {
            sum += element.count * element.clay.price;
          });
        }
        return sum;
      },
    },
  };
</script>

<style></style>
