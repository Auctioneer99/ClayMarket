<template>
  <div id="app-layout">
    <Header />
    <router-link class="nav-link" to="/"
      ><button class="btn btn-light btn-lg">Home</button></router-link
    >
    <Footer />
  </div>
</template>

<script>
  import Header from "../views/Header.vue";
  import Footer from "../views/Footer.vue";

  export default {
    components: {
      Header,
      Footer,
    },
  };
</script>
