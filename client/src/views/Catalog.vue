<template>
  Каталог<br />
  <table border="0" width="100%">
    <tr>
      <td width="50%">
        <h3>Издатели</h3>
        <ul>
          <li v-for="supplier in suppliers" :key="supplier.id">
            <router-link
              :to="{
                name: 'showcase',
                params: { type: 'supplier', id: supplier.id },
                query: { type: 'supplier', id: supplier.id },
              }"
            >
              {{ supplier.name }}
              <br />
              {{ supplier.description }}
            </router-link>
          </li>
        </ul>
      </td>
      <td width="50%">
        <h3>Категории</h3>
        <ul>
          <li v-for="category in categories" :key="category.id">
            <router-link
              :to="{
                name: 'showcase',
                params: { type: 'category', id: category.id },
                query: { type: 'category', id: category.id },
              }"
            >
              {{ category.name }}
              <br />
              {{ category.description }}
            </router-link>
          </li>
        </ul>
      </td>
    </tr>
  </table>
</template>

<script>
  import service from "../domain/clayMarketService.js";

  export default {
    data() {
      return {
        categories: [],
        suppliers: [],
      };
    },
    async beforeCreate() {
      this.categories = await service.getCategories();
      this.suppliers = await service.getSuppliers();
    },
  };
</script>

<style></style>
