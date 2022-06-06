export default function ShopHeader({ headerStyle, title }) {
  return (
    <header id="shop-header" className={headerStyle}>
      <h1 className="shop-header__title">{title}</h1>
    </header>
  );
}
