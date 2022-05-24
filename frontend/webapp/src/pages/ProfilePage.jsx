import { useParams } from "react-router-dom";

export default function ProfilePage() {
  const { id } = useParams();

  return <h1>Hello {id}</h1>;
}
