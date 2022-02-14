<template>
  <table border="1" width="100%" align="right">
    <tr>
      <td align="center" width="30%">Топ поставщиков по количеству товаров</td>
      <td>
        <li v-for="sup in suppliersByClay" :key="sup.id">
          <router-link
            :to="{
              name: 'showcase',
              params: { type: 'supplier', id: sup.id },
              query: { type: 'supplier', id: sup.id },
            }"
          >
            {{ sup.name }}
            <br />
            {{ sup.count }}
          </router-link>
        </li>
      </td>
    </tr>
    <tr>
      <td align="center">Топ товаров по цене</td>
      <td>
        <li v-for="clay in clayByPrice" :key="clay.id">
          {{ clay.name }}
          <br />
          {{ clay.price }}
        </li>
      </td>
    </tr>
    <tr>
      <td align="center">Топ покупаемых товаров</td>
      <td>
        <li v-for="clay in clayByOrder" :key="clay.id">
          {{ clay.name }}
          <br />
          {{ clay.count }}
        </li>
      </td>
    </tr>
  </table>
</template>

<script>
  import service from "../domain/clayMarketService.js";

  export default {
    data() {
      return {
        suppliersByClay: [],
        clayByPrice: [],
        clayByOrder: [],
      };
    },
    beforeMount() {
      this.loadListItem();
    },
    methods: {
      async loadListItem() {
        this.suppliersByClay = await service.getSuppliersByClay();
        this.clayByPrice = await service.getClayByPrice();
        this.clayByOrder = await service.getClayByOrder();
      },
    },
  };
</script>

<style></style>
