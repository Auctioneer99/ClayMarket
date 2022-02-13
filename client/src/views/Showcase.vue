<template>
  <Loader :loading="showLoader" />
  <table border="1" width="100%" align="right">
    <tr v-for="item in listItems" :key="item.id">
      <td align="center">
        <img
          width="200"
          :src="`images/${item.image}`"
          :alt="`${item.name}`"
          border="0"
        />
        <button v-on:click="addToBasket(item.id)">Положить в корзину</button>
      </td>

      <td>
        <table>
          <tr>
            <td align="right">Поставщики:</td>
            <td>
              <li v-for="supplier in item.suppliers" :key="supplier.id">
                {{ supplier.name }}
              </li>
            </td>
          </tr>
          <tr>
            <td align="right">Название:</td>
            <td>{{ item.name }}</td>
          </tr>
          <tr>
            <td align="right">Категория:</td>
            <td>{{ item.category.name }}</td>
          </tr>
          <tr>
            <td align="right">Цена:</td>
            <td>{{ item.price }}</td>
          </tr>
          <tr>
            <td align="right">Масса:</td>
            <td>{{ item.weight }}</td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <Pagination
    v-if="listItems"
    :total-pages="totalPages"
    :per-page="recordsPerPage"
    :current-page="page"
    @pagechanged="onPageChange"
  />
</template>

<script>
  import service from "../domain/clayMarketService.js";
  import keycloak from "../domain/keycloak.js";
  import Pagination from "../components/Pagination";
  import Loader from "../components/Loader";

  export default {
    components: {
      Pagination,
      Loader,
    },
    data() {
      return {
        showLoader: false,
        listItems: [],
        page: 0,
        totalPages: 0,
        totalRecords: 0,
        recordsPerPage: 10,
        enterpageno: "",
      };
    },
    props: ["type", "id"],
    beforeMount() {
      this.loadListItem();
    },
    methods: {
      addToBasket: function (id) {
        keycloak.login(this.$router.currentRoute.value.fullPath);
        service.addToBasket(id);
      },
      async loadListItem() {
        this.showLoader = true;
        var response = await service.getItems(
          this.type,
          this.id,
          this.page,
          this.recordsPerPage
        );
        console.log(response);
        this.showLoader = false;
        this.listItems = response.content;
        this.totalPages = response.totalPages;
        this.totalRecords = response.totalElements;
      },
      onPageChange(page) {
        this.page = page;
        this.loadListItem();
      },
      onChangeRecordsPerPage() {
        this.loadListItem();
      },
      gotoPage() {
        if (!isNaN(parseInt(this.enterpageno))) {
          this.page = parseInt(this.enterpageno);
          this.loadListItem();
        }
      },
    },
  };
</script>

<style></style>
