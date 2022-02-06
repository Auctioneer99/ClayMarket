<template>
  <font face="Arial" size="+2"> <i>Каталог</i> </font><br />
  <table border="0" width="100%">
    <tr>
      <td width="50%">
        <center>
          <h3>Издатели</h3>
        </center>
        <ul>
          <li v-for="publisher in publishers" :key="publisher.id">
            <a>{{ publisher }}</a>
          </li>
        </ul>
      </td>
      <td width="50%">
        <center>
          <h3>Категории</h3>
        </center>
        <ul>
          <li v-for="category in categories" :key="category.id">
            <a>{{ category }}</a>
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
        publishers: [],
      };
    },
    async beforeCreate() {
      this.categories = await service.getCategories();
      this.publishers = await service.getPublishers();
    },
  };
</script>

<style></style>
