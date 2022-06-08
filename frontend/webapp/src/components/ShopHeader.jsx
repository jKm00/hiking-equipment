/**
 * Returns a header component for the shop page
 * @param {*} headerStyle, a list of classes to be applied to the header element
 * @param {*} title, the title to be displayed in the header element
 * @returns
 */
export default function ShopHeader({ headerStyle, title }) {
  return (
    <header id="shop-header" className={headerStyle}>
      <h1 className="shop-header__title">{title}</h1>
    </header>
  );
}
