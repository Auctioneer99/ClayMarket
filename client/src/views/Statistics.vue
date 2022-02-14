<template>
  <table border="1" width="100%" align="right">
    <tr>
      <td align="center"></td>

      <td>
        <li></li>
      </td>
    </tr>
  </table>
</template>

<script>
  import service from "../domain/clayMarketService.js";

  export default {
    data() {
      return {};
    },
    beforeMount() {
      this.loadListItem();
    },
    methods: {
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
    },
  };
</script>

<style></style>
