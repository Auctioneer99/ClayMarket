<template>
  <table border="1" width="100%" align="right">
    <tr v-for="order in orders" :key="order.id">
      <table border="1" width="100%" align="right">
        <tr v-for="item in order.basketItems" :key="item.id">
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
                  <li
                    v-for="supplier in item.clay.suppliers"
                    :key="supplier.id"
                  >
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
              <tr>
                <td align="right">Количество:</td>
                <td>{{ item.count }}</td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <h3>
        Сумма: {{ getPrice(order) }}
        <br />
        Дата: {{ new Date(order.dateOrdered) }}
      </h3>
      <br />
      <hr />
      <br />
    </tr>
  </table>
</template>

<script>
  import service from "../domain/clayMarketService.js";
  import authService from "../domain/keycloak.js";

  export default {
    data() {
      return {
        orders: {},
      };
    },
    async beforeCreate() {
      await authService.login(this.$router.currentRoute.value.fullPath);
      this.orders = await service.getOrders();
    },
    methods: {
      getPrice(item) {
        var sum = 0;
        item.basketItems.forEach((element) => {
          sum += element.count * element.clay.price;
        });
        return sum;
      },
    },
  };
</script>

<style></style>
